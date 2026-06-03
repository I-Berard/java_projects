import React, { useEffect, useState } from 'react';
import { useNavigate, useParams, Link } from 'react-router-dom';
import { ArrowLeft, Loader2, Save } from 'lucide-react';
import api from '../api';

const StudentForm = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const isEdit = Boolean(id);
  
  const [formData, setFormData] = useState({
    userId: '',
    fullName: '',
    admissionNumber: ''
  });
  
  const [users, setUsers] = useState([]);
  
  const [loading, setLoading] = useState(isEdit);
  const [saving, setSaving] = useState(false);
  const [error, setError] = useState('');

  useEffect(() => {
    const fetchInitialData = async () => {
      try {
        const usersResponse = await api.get('/users');
        setUsers(usersResponse.data || []);
        
        if (isEdit) {
          const response = await api.get(`/students/${id}`);
          setFormData({
            userId: response.data.user?.id || '',
            fullName: response.data.fullName || '',
            admissionNumber: response.data.admissionNumber || ''
          });
        }
      } catch (error) {
        setError('Failed to fetch required data.');
      } finally {
        setLoading(false);
      }
    };
    
    fetchInitialData();
  }, [id, isEdit]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prev => ({ ...prev, [name]: value }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setSaving(true);
    setError('');

    try {
      if (isEdit) {
        await api.put(`/students/${id}`, formData);
      } else {
        await api.post('/students', formData);
      }
      navigate('/dashboard/students');
    } catch (err) {
      setError(err.response?.data?.message || 'Failed to save student.');
      setSaving(false);
    }
  };

  if (loading) {
    return <div className="h-full flex items-center justify-center"><Loader2 className="animate-spin text-primary-500" size={32} /></div>;
  }

  return (
    <div className="max-w-2xl mx-auto space-y-6">
      <div className="flex items-center gap-4">
        <Link to="/dashboard/students" className="p-2 text-slate-400 hover:text-slate-600 bg-white rounded-lg border border-slate-200 shadow-sm transition-all">
          <ArrowLeft size={20} />
        </Link>
        <div>
          <h1 className="text-2xl font-bold text-slate-900">{isEdit ? 'Edit Student' : 'Add New Student'}</h1>
          <p className="text-slate-500">Fill in the student details below.</p>
        </div>
      </div>

      <div className="bg-white rounded-2xl border border-slate-100 shadow-sm p-6">
        {error && (
          <div className="bg-red-50 text-red-600 p-4 rounded-xl text-sm mb-6 border border-red-100">
            {error}
          </div>
        )}

        <form onSubmit={handleSubmit} className="space-y-5">
          <div>
            <label className="block text-sm font-medium text-slate-700 mb-1">User Account</label>
            <select
              name="userId"
              required
              value={formData.userId}
              onChange={handleChange}
              disabled={isEdit}
              className="glass-input block w-full px-4 py-2.5 sm:text-sm"
            >
              <option value="">Select a user...</option>
              {users.map(user => (
                <option key={user.id} value={user.id}>
                  {user.email} ({user.role})
                </option>
              ))}
            </select>
          </div>

          <div>
            <label className="block text-sm font-medium text-slate-700 mb-1">Full Name</label>
            <input
              type="text"
              name="fullName"
              required
              value={formData.fullName}
              onChange={handleChange}
              className="glass-input block w-full px-4 py-2.5 sm:text-sm"
              placeholder="e.g. John Doe"
            />
          </div>
          
          <div>
            <label className="block text-sm font-medium text-slate-700 mb-1">Admission Number</label>
            <input
              type="text"
              name="admissionNumber"
              required
              value={formData.admissionNumber}
              onChange={handleChange}
              className="glass-input block w-full px-4 py-2.5 sm:text-sm"
              placeholder="e.g. STU-2023-001"
            />
          </div>

          <div className="pt-4 border-t border-slate-100 flex justify-end gap-3">
            <Link to="/dashboard/students" className="btn-secondary">
              Cancel
            </Link>
            <button
              type="submit"
              disabled={saving}
              className="btn-primary flex items-center gap-2"
            >
              {saving ? <Loader2 size={18} className="animate-spin" /> : <Save size={18} />}
              <span>{isEdit ? 'Update Student' : 'Save Student'}</span>
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default StudentForm;
