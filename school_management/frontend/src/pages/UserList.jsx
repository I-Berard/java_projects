import React, { useState, useEffect } from 'react';
import api from '../api';
import { Shield, User, Edit2, Check, X, AlertCircle, Plus } from 'lucide-react';

const UserList = () => {
  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');
  const [showAddModal, setShowAddModal] = useState(false);
  const [newUser, setNewUser] = useState({ email: '', password: '', role: 'STUDENT' });
  const [editingUserId, setEditingUserId] = useState(null);

  useEffect(() => {
    fetchUsers();
  }, []);

  const fetchUsers = async () => {
    try {
      const response = await api.get('/users');
      setUsers(response.data);
    } catch (err) {
      setError('Failed to fetch users.');
      console.error(err);
    } finally {
      setLoading(false);
    }
  };

  const handleSaveUser = async (e) => {
    e.preventDefault();
    try {
      if (editingUserId) {
        const response = await api.put(`/users/${editingUserId}`, newUser);
        setUsers(users.map(u => u.id === editingUserId ? response.data : u));
      } else {
        const response = await api.post('/users', newUser);
        setUsers([...users, response.data]);
      }
      handleCloseModal();
    } catch (err) {
      alert('Failed to save user.');
      console.error(err);
    }
  };

  const handleCloseModal = () => {
    setShowAddModal(false);
    setNewUser({ email: '', password: '', role: 'STUDENT' });
    setEditingUserId(null);
  };

  const openEditModal = (user) => {
    setNewUser({
      email: user.email || '',
      password: '',
      role: user.role || 'STUDENT'
    });
    setEditingUserId(user.id);
    setShowAddModal(true);
  };

  if (loading) return <div className="p-8 flex justify-center"><div className="animate-spin h-8 w-8 border-4 border-primary-500 border-t-transparent rounded-full"></div></div>;

  return (
    <div className="space-y-6">
      <div className="flex justify-between items-center">
        <div>
          <h1 className="text-2xl font-bold text-slate-900">User Role Management</h1>
          <p className="text-slate-500">View and modify user roles</p>
        </div>
        <button 
          onClick={() => setShowAddModal(true)}
          className="bg-primary-600 hover:bg-primary-700 text-white px-4 py-2 rounded-xl flex items-center transition-colors"
        >
          <Plus size={20} className="mr-2" /> Add User
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
            <h3 className="text-lg font-bold mb-4 text-slate-900">{editingUserId ? 'Edit User' : 'Add New User'}</h3>
            <form onSubmit={handleSaveUser} className="space-y-4">
              <div>
                <label className="block text-sm font-medium text-slate-700 mb-1">Email</label>
                <input required type="email" value={newUser.email} onChange={(e) => setNewUser({...newUser, email: e.target.value})} className="w-full px-3 py-2 border border-slate-200 rounded-xl focus:outline-none focus:ring-2 focus:ring-primary-500" />
              </div>
              <div>
                <label className="block text-sm font-medium text-slate-700 mb-1">{editingUserId ? 'New Password (Optional)' : 'Password'}</label>
                <input required={!editingUserId} type="password" value={newUser.password} onChange={(e) => setNewUser({...newUser, password: e.target.value})} className="w-full px-3 py-2 border border-slate-200 rounded-xl focus:outline-none focus:ring-2 focus:ring-primary-500" />
              </div>
              <div>
                <label className="block text-sm font-medium text-slate-700 mb-1">Role</label>
                <select value={newUser.role} onChange={(e) => setNewUser({...newUser, role: e.target.value})} className="w-full px-3 py-2 border border-slate-200 rounded-xl focus:outline-none focus:ring-2 focus:ring-primary-500">
                  <option value="STUDENT">Student</option>
                  <option value="TEACHER">Teacher</option>
                  <option value="ADMIN">Admin</option>
                </select>
              </div>
              <div className="flex justify-end space-x-3 mt-6">
                <button type="button" onClick={handleCloseModal} className="px-4 py-2 text-slate-600 hover:bg-slate-50 rounded-xl">Cancel</button>
                <button type="submit" className="px-4 py-2 bg-primary-600 hover:bg-primary-700 text-white rounded-xl">Save User</button>
              </div>
            </form>
          </div>
        </div>
      )}

      <div className="bg-white rounded-2xl shadow-sm border border-slate-100 overflow-hidden">
        <table className="w-full text-left border-collapse">
          <thead>
            <tr className="bg-slate-50 text-slate-600 text-sm border-b border-slate-100">
              <th className="p-4 font-medium">Email</th>
              <th className="p-4 font-medium">Current Role</th>
              <th className="p-4 font-medium text-right">Actions</th>
            </tr>
          </thead>
          <tbody className="divide-y divide-slate-100">
            {users.map(user => (
              <tr key={user.id} className="hover:bg-slate-50/50 transition-colors">
                <td className="p-4">
                  <div className="flex items-center space-x-3">
                    <div className="w-10 h-10 rounded-full bg-primary-100 flex items-center justify-center text-primary-600 font-bold">
                      {user.email ? user.email.charAt(0).toUpperCase() : '?'}
                    </div>
                    <span className="font-medium text-slate-900">{user.email || 'No Email'}</span>
                  </div>
                </td>
                <td className="p-4">
                  <span className={`inline-flex items-center px-2.5 py-1 rounded-full text-xs font-medium ${
                    user.role === 'ADMIN' ? 'bg-purple-100 text-purple-700' :
                    user.role === 'TEACHER' ? 'bg-blue-100 text-blue-700' :
                    'bg-emerald-100 text-emerald-700'
                  }`}>
                    {user.role === 'ADMIN' ? <Shield size={12} className="mr-1" /> : <User size={12} className="mr-1" />}
                    {user.role}
                  </span>
                </td>
                <td className="p-4 text-right">
                  <button onClick={() => openEditModal(user)} className="p-1.5 text-slate-400 hover:text-primary-600 hover:bg-primary-50 rounded-lg transition-colors">
                    <Edit2 size={18} />
                  </button>
                </td>
              </tr>
            ))}
            {users.length === 0 && (
              <tr>
                <td colSpan="3" className="p-8 text-center text-slate-500">No users found.</td>
              </tr>
            )}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default UserList;
