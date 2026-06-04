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

      <div className="bg-white rounded-3xl p-6 shadow-sm">
        <div className="flex flex-col sm:flex-row justify-between items-center mb-6">
          <h2 className="text-lg font-bold text-slate-800">Students Information</h2>
          <div className="flex space-x-3 mt-4 sm:mt-0">
            <div className="relative">
              <input
                type="text"
                placeholder="Search by name or roll"
                value={search}
                onChange={(e) => setSearch(e.target.value)}
                className="pl-4 pr-10 py-2 bg-slate-50 border border-slate-100 rounded-xl text-sm focus:outline-none focus:ring-1 focus:ring-primary-500 w-64"
              />
              <Search size={16} className="absolute right-3 top-2.5 text-slate-400" />
            </div>
            <button className="px-4 py-2 bg-slate-50 border border-slate-100 rounded-xl text-sm text-slate-600 flex items-center hover:bg-slate-100 transition-colors">
              Last 30 days <span className="ml-2 text-xs">▼</span>
            </button>
          </div>
        </div>

        <div className="overflow-x-auto">
          <table className="w-full text-left border-collapse">
            <thead className="border-b border-slate-100">
              <tr className="text-slate-400 text-xs uppercase tracking-wider">
                <th className="p-4 font-medium w-12"><input type="checkbox" className="rounded text-primary-600 focus:ring-primary-500 border-slate-300" /></th>
                <th className="p-4 font-medium">Students Name</th>
                <th className="p-4 font-medium">Roll</th>
                <th className="p-4 font-medium">Email</th>
                <th className="p-4 font-medium">Class</th>
                <th className="p-4 font-medium text-right">Action</th>
              </tr>
            </thead>
            <tbody className="divide-y divide-slate-50">
              {loading ? (
                <tr>
                  <td colSpan="6" className="p-8 text-center">
                    <Loader2 className="animate-spin text-primary-500 mx-auto" size={24} />
                  </td>
                </tr>
              ) : filteredStudents.length === 0 ? (
                <tr>
                  <td colSpan="6" className="p-8 text-center text-slate-500">No students found.</td>
                </tr>
              ) : (
                filteredStudents.map((student) => (
                  <tr key={student.id} className="hover:bg-slate-50/50 transition-colors group">
                    <td className="p-4"><input type="checkbox" className="rounded text-primary-600 focus:ring-primary-500 border-slate-300" /></td>
                    <td className="p-4">
                      <div className="flex items-center space-x-3">
                        <img src={`https://i.pravatar.cc/150?u=${student.id}`} alt="avatar" className="w-8 h-8 rounded-full object-cover" />
                        <span className="font-semibold text-slate-800">{student.fullName}</span>
                      </div>
                    </td>
                    <td className="p-4 text-slate-500 text-sm">#{student.admissionNumber}</td>
                    <td className="p-4 text-slate-500 text-sm">{student.user?.email || 'N/A'}</td>
                    <td className="p-4 text-slate-500 text-sm">01</td>
                    <td className="p-4 flex justify-end gap-3 text-slate-400 opacity-0 group-hover:opacity-100 transition-opacity">
                      <button 
                        onClick={() => handleDelete(student.id)}
                        disabled={deleteLoading === student.id}
                        className="hover:text-red-500 transition-colors disabled:opacity-50"
                      >
                        {deleteLoading === student.id ? <Loader2 size={18} className="animate-spin" /> : <Trash2 size={18} />}
                      </button>
                      <Link 
                        to={`/dashboard/students/${student.id}/edit`} 
                        className="hover:text-primary-600 transition-colors"
                      >
                        <Edit2 size={18} />
                      </Link>
                    </td>
                  </tr>
                ))
              )}
            </tbody>
          </table>
        </div>
        
        {/* Pagination placeholder */}
        <div className="flex items-center justify-between mt-6 pt-4 border-t border-slate-50">
          <div className="text-sm text-slate-500">Showing 1 to {filteredStudents.length} of {filteredStudents.length} entries</div>
          <div className="flex space-x-1">
            <button className="w-8 h-8 flex items-center justify-center rounded-lg text-slate-400 hover:bg-slate-50">&lt;</button>
            <button className="w-8 h-8 flex items-center justify-center rounded-lg bg-primary-600 text-white">1</button>
            <button className="w-8 h-8 flex items-center justify-center rounded-lg text-slate-600 hover:bg-slate-50">2</button>
            <button className="w-8 h-8 flex items-center justify-center rounded-lg text-slate-600 hover:bg-slate-50">3</button>
            <button className="w-8 h-8 flex items-center justify-center rounded-lg text-slate-400 hover:bg-slate-50">&gt;</button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default StudentList;
