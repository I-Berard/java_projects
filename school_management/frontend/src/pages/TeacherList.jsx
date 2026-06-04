import React, { useState, useEffect } from 'react';
import api from '../api';
import { Users, AlertCircle, Plus, Edit2 } from 'lucide-react';

const TeacherList = () => {
  const [teachers, setTeachers] = useState([]);
  const [users, setUsers] = useState([]); // To populate user dropdown
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');
  const [showAddModal, setShowAddModal] = useState(false);
  const [newTeacher, setNewTeacher] = useState({ userId: '', fullName: '', employeeNumber: '', department: '' });
  const [editingTeacherId, setEditingTeacherId] = useState(null);

  useEffect(() => {
    fetchTeachers();
    fetchUsers();
  }, []);

  const fetchTeachers = async () => {
    try {
      const response = await api.get('/teachers');
      setTeachers(response.data);
    } catch (err) {
      setError('Failed to fetch teachers.');
      console.error(err);
    } finally {
      setLoading(false);
    }
  };

  const fetchUsers = async () => {
    try {
      const response = await api.get('/users/role/TEACHER');
      setUsers(response.data);
    } catch (err) {
      console.error('Failed to fetch users', err);
    }
  };

  const handleSaveTeacher = async (e) => {
    e.preventDefault();
    try {
      if (editingTeacherId) {
        const response = await api.put(`/teachers/${editingTeacherId}`, newTeacher);
        setTeachers(teachers.map(t => t.id === editingTeacherId ? response.data : t));
      } else {
        const response = await api.post('/teachers', newTeacher);
        setTeachers([...teachers, response.data]);
      }
      handleCloseModal();
    } catch (err) {
      alert('Failed to save teacher.');
      console.error(err);
    }
  };

  const handleCloseModal = () => {
    setShowAddModal(false);
    setNewTeacher({ userId: '', fullName: '', employeeNumber: '', department: '' });
    setEditingTeacherId(null);
  };

  const openEditModal = (teacher) => {
    setNewTeacher({
      userId: teacher.user?.id || teacher.userId || '',
      fullName: teacher.fullName || '',
      employeeNumber: teacher.employeeNumber || '',
      department: teacher.department || ''
    });
    setEditingTeacherId(teacher.id);
    setShowAddModal(true);
  };

  if (loading) return <div className="p-8 flex justify-center"><div className="animate-spin h-8 w-8 border-4 border-primary-500 border-t-transparent rounded-full"></div></div>;

  return (
    <div className="space-y-6">
      <div className="flex justify-between items-center">
        <div>
          <h1 className="text-2xl font-bold text-slate-900">Teacher Management</h1>
          <p className="text-slate-500">View registered teachers</p>
        </div>
        <button 
          onClick={() => setShowAddModal(true)}
          className="bg-primary-600 hover:bg-primary-700 text-white px-4 py-2 rounded-xl flex items-center transition-colors"
        >
          <Plus size={20} className="mr-2" /> Add Teacher
        </button>
      </div>

      {error && (
        <div className="bg-red-50 text-red-600 p-4 rounded-xl flex items-center">
          <AlertCircle className="mr-2" size={20} />
          {error}
        </div>
      )}

      {showAddModal && (
        <div className="fixed inset-0 bg-slate-900/50 flex items-center justify-center z-50">
          <div className="bg-white rounded-2xl p-6 w-full max-w-md shadow-xl">
            <h3 className="text-lg font-bold mb-4 text-slate-900">{editingTeacherId ? 'Edit Teacher' : 'Add New Teacher'}</h3>
            <form onSubmit={handleSaveTeacher} className="space-y-4">
              <div>
                <label className="block text-sm font-medium text-slate-700 mb-1">User Account</label>
                <select required value={newTeacher.userId} onChange={(e) => setNewTeacher({...newTeacher, userId: e.target.value})} disabled={!!editingTeacherId} className="w-full px-3 py-2 border border-slate-200 rounded-xl focus:outline-none focus:ring-2 focus:ring-primary-500">
                  <option value="">Select User...</option>
                  {users.map(u => (
                    <option key={u.id} value={u.id}>{u.email} ({u.role})</option>
                  ))}
                  {editingTeacherId && !users.find(u => u.id === newTeacher.userId) && (
                     <option value={newTeacher.userId}>Current User (Kept)</option>
                  )}
                </select>
              </div>
              <div>
                <label className="block text-sm font-medium text-slate-700 mb-1">Full Name</label>
                <input required type="text" value={newTeacher.fullName} onChange={(e) => setNewTeacher({...newTeacher, fullName: e.target.value})} className="w-full px-3 py-2 border border-slate-200 rounded-xl focus:outline-none focus:ring-2 focus:ring-primary-500" />
              </div>
              <div>
                <label className="block text-sm font-medium text-slate-700 mb-1">Employee Number</label>
                <input required type="text" value={newTeacher.employeeNumber} onChange={(e) => setNewTeacher({...newTeacher, employeeNumber: e.target.value})} className="w-full px-3 py-2 border border-slate-200 rounded-xl focus:outline-none focus:ring-2 focus:ring-primary-500" />
              </div>
              <div>
                <label className="block text-sm font-medium text-slate-700 mb-1">Department</label>
                <input required type="text" value={newTeacher.department} onChange={(e) => setNewTeacher({...newTeacher, department: e.target.value})} className="w-full px-3 py-2 border border-slate-200 rounded-xl focus:outline-none focus:ring-2 focus:ring-primary-500" />
              </div>
              <div className="flex justify-end space-x-3 mt-6">
                <button type="button" onClick={handleCloseModal} className="px-4 py-2 text-slate-600 hover:bg-slate-50 rounded-xl">Cancel</button>
                <button type="submit" className="px-4 py-2 bg-primary-600 hover:bg-primary-700 text-white rounded-xl">Save Teacher</button>
              </div>
            </form>
          </div>
        </div>
      )}

      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
        {teachers.map(teacher => (
          <div key={teacher.id} className="bg-white p-6 rounded-2xl border border-slate-100 shadow-sm hover:shadow-md transition-shadow relative group">
            <button 
              onClick={() => openEditModal(teacher)}
              className="absolute top-4 right-4 p-2 text-slate-400 hover:text-primary-600 hover:bg-primary-50 rounded-lg transition-colors opacity-0 group-hover:opacity-100"
            >
              <Edit2 size={18} />
            </button>
            <div className="flex items-start space-x-4">
              <div className="w-12 h-12 rounded-xl bg-blue-50 flex items-center justify-center text-blue-600 shrink-0">
                <Users size={24} />
              </div>
              <div>
                <h3 className="text-lg font-bold text-slate-900">{teacher.fullName}</h3>
                <p className="text-slate-500 text-sm mt-1">{teacher.department || 'No Department'}</p>
                <div className="mt-4 flex items-center space-x-2">
                  <span className="px-2.5 py-1 bg-slate-100 text-slate-600 rounded-full text-xs font-medium border border-slate-200">
                    Emp #: {teacher.employeeNumber}
                  </span>
                </div>
              </div>
            </div>
          </div>
        ))}
      </div>
      
      {teachers.length === 0 && !error && (
        <div className="bg-white p-12 rounded-2xl border border-slate-100 text-center">
          <Users size={48} className="mx-auto text-slate-300 mb-4" />
          <h3 className="text-lg font-bold text-slate-900">No teachers found</h3>
          <p className="text-slate-500 mt-1">There are no teachers registered in the system yet.</p>
        </div>
      )}
    </div>
  );
};

export default TeacherList;
