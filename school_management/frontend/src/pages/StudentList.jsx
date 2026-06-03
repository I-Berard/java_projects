import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { Plus, Edit2, Trash2, Search, Loader2 } from 'lucide-react';
import api from '../api';

const StudentList = () => {
  const [students, setStudents] = useState([]);
  const [loading, setLoading] = useState(true);
  const [search, setSearch] = useState('');
  const [deleteLoading, setDeleteLoading] = useState(null);

  useEffect(() => {
    fetchStudents();
  }, []);

  const fetchStudents = async () => {
    try {
      const response = await api.get('/students');
      setStudents(response.data);
    } catch (error) {
      console.error("Failed to fetch students", error);
    } finally {
      setLoading(false);
    }
  };

  const handleDelete = async (id) => {
    if (!window.confirm("Are you sure you want to delete this student?")) return;
    
    setDeleteLoading(id);
    try {
      await api.delete(`/students/${id}`);
      setStudents(students.filter(s => s.id !== id));
    } catch (error) {
      console.error("Failed to delete student", error);
    } finally {
      setDeleteLoading(null);
    }
  };

  const filteredStudents = students.filter(student => 
    student.fullName?.toLowerCase().includes(search.toLowerCase()) ||
    student.user?.email?.toLowerCase().includes(search.toLowerCase()) ||
    student.admissionNumber?.toLowerCase().includes(search.toLowerCase())
  );

  return (
    <div className="space-y-6">
      <div className="flex flex-col sm:flex-row justify-between items-start sm:items-center gap-4">
        <div>
          <h1 className="text-2xl font-bold text-slate-900">Students</h1>
          <p className="text-slate-500">Manage school students</p>
        </div>
        
        <Link to="/dashboard/students/new" className="btn-primary flex items-center gap-2">
          <Plus size={18} />
          <span>Add Student</span>
        </Link>
      </div>

      <div className="bg-white rounded-2xl border border-slate-100 shadow-sm overflow-hidden">
        <div className="p-4 border-b border-slate-100">
          <div className="relative max-w-md">
            <div className="absolute inset-y-0 left-0 pl-3 flex items-center pointer-events-none text-slate-400">
              <Search size={18} />
            </div>
            <input
              type="text"
              placeholder="Search students..."
              value={search}
              onChange={(e) => setSearch(e.target.value)}
              className="glass-input block w-full pl-10 py-2 sm:text-sm"
            />
          </div>
        </div>

        <div className="overflow-x-auto">
          <table className="w-full text-left border-collapse">
            <thead>
              <tr className="bg-slate-50 text-slate-500 text-sm">
                <th className="p-4 font-medium">Name</th>
                <th className="p-4 font-medium">Email</th>
                <th className="p-4 font-medium">Admission Number</th>
                <th className="p-4 font-medium text-right">Actions</th>
              </tr>
            </thead>
            <tbody className="divide-y divide-slate-50">
              {loading ? (
                <tr>
                  <td colSpan="4" className="p-8 text-center">
                    <Loader2 className="animate-spin text-primary-500 mx-auto" size={24} />
                  </td>
                </tr>
              ) : filteredStudents.length === 0 ? (
                <tr>
                  <td colSpan="4" className="p-8 text-center text-slate-500">No students found.</td>
                </tr>
              ) : (
                filteredStudents.map((student) => (
                  <tr key={student.id} className="hover:bg-slate-50/50 transition-colors">
                    <td className="p-4 font-medium text-slate-900">{student.fullName}</td>
                    <td className="p-4 text-slate-600">{student.user?.email || 'N/A'}</td>
                    <td className="p-4 text-slate-600">{student.admissionNumber}</td>
                    <td className="p-4 flex justify-end gap-2">
                      <Link 
                        to={`/dashboard/students/${student.id}/edit`} 
                        className="p-2 text-slate-400 hover:text-primary-600 bg-white rounded-lg border border-slate-200 shadow-sm transition-all"
                      >
                        <Edit2 size={16} />
                      </Link>
                      <button 
                        onClick={() => handleDelete(student.id)}
                        disabled={deleteLoading === student.id}
                        className="p-2 text-slate-400 hover:text-red-600 bg-white rounded-lg border border-slate-200 shadow-sm transition-all disabled:opacity-50"
                      >
                        {deleteLoading === student.id ? <Loader2 size={16} className="animate-spin" /> : <Trash2 size={16} />}
                      </button>
                    </td>
                  </tr>
                ))
              )}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
};

export default StudentList;
