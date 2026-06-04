import React, { useState, useEffect } from 'react';
import api from '../api';
import { UserCheck, AlertCircle, Plus } from 'lucide-react';

const EnrollmentList = () => {
  const [enrollments, setEnrollments] = useState([]);
  const [students, setStudents] = useState([]);
  const [courses, setCourses] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');
  const [showAddModal, setShowAddModal] = useState(false);
  const [newEnrollment, setNewEnrollment] = useState({ studentId: '', courseId: '' });

  useEffect(() => {
    fetchEnrollments();
    fetchStudents();
    fetchCourses();
  }, []);

  const fetchEnrollments = async () => {
    try {
      const response = await api.get('/enrollments');
      setEnrollments(response.data);
    } catch (err) {
      setError('Failed to fetch enrollments.');
      console.error(err);
    } finally {
      setLoading(false);
    }
  };

  const fetchStudents = async () => {
    try {
      // Assuming GET /students exists as per StudentDashboard/AdminDashboard calls
      const response = await api.get('/students');
      setStudents(response.data);
    } catch (err) {
      console.error('Failed to fetch students', err);
    }
  };

  const fetchCourses = async () => {
    try {
      const response = await api.get('/courses');
      setCourses(response.data);
    } catch (err) {
      console.error('Failed to fetch courses', err);
    }
  };

  const handleAddEnrollment = async (e) => {
    e.preventDefault();
    try {
      const response = await api.post('/enrollments', newEnrollment);
      setEnrollments([...enrollments, response.data]);
      setShowAddModal(false);
      setNewEnrollment({ studentId: '', courseId: '' });
    } catch (err) {
      alert('Failed to add enrollment.');
      console.error(err);
    }
  };

  if (loading) return <div className="p-8 flex justify-center"><div className="animate-spin h-8 w-8 border-4 border-primary-500 border-t-transparent rounded-full"></div></div>;

  return (
    <div className="space-y-6">
      <div className="flex justify-between items-center">
        <div>
          <h1 className="text-2xl font-bold text-slate-900">Enrollment Management</h1>
          <p className="text-slate-500">View and manage student enrollments</p>
        </div>
        <button 
          onClick={() => setShowAddModal(true)}
          className="bg-primary-600 hover:bg-primary-700 text-white px-4 py-2 rounded-xl flex items-center transition-colors"
        >
          <Plus size={20} className="mr-2" /> Add Enrollment
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
            <h3 className="text-lg font-bold mb-4 text-slate-900">Add New Enrollment</h3>
            <form onSubmit={handleAddEnrollment} className="space-y-4">
              <div>
                <label className="block text-sm font-medium text-slate-700 mb-1">Student</label>
                <select required value={newEnrollment.studentId} onChange={(e) => setNewEnrollment({...newEnrollment, studentId: e.target.value})} className="w-full px-3 py-2 border border-slate-200 rounded-xl focus:outline-none focus:ring-2 focus:ring-primary-500">
                  <option value="">Select Student...</option>
                  {students.map(s => (
                    <option key={s.id} value={s.id}>{s.firstName} {s.lastName}</option>
                  ))}
                </select>
              </div>
              <div>
                <label className="block text-sm font-medium text-slate-700 mb-1">Course</label>
                <select required value={newEnrollment.courseId} onChange={(e) => setNewEnrollment({...newEnrollment, courseId: e.target.value})} className="w-full px-3 py-2 border border-slate-200 rounded-xl focus:outline-none focus:ring-2 focus:ring-primary-500">
                  <option value="">Select Course...</option>
                  {courses.map(c => (
                    <option key={c.id} value={c.id}>{c.title} ({c.code})</option>
                  ))}
                </select>
              </div>
              <div className="flex justify-end space-x-3 mt-6">
                <button type="button" onClick={() => setShowAddModal(false)} className="px-4 py-2 text-slate-600 hover:bg-slate-50 rounded-xl">Cancel</button>
                <button type="submit" className="px-4 py-2 bg-primary-600 hover:bg-primary-700 text-white rounded-xl">Save Enrollment</button>
              </div>
            </form>
          </div>
        </div>
      )}

      <div className="bg-white rounded-2xl shadow-sm border border-slate-100 overflow-hidden">
        <table className="w-full text-left border-collapse">
          <thead>
            <tr className="bg-slate-50 text-slate-600 text-sm border-b border-slate-100">
              <th className="p-4 font-medium">Student</th>
              <th className="p-4 font-medium">Course</th>
              <th className="p-4 font-medium">Enrollment Date</th>
            </tr>
          </thead>
          <tbody className="divide-y divide-slate-100">
            {enrollments.map(enrollment => (
              <tr key={enrollment.id} className="hover:bg-slate-50/50 transition-colors">
                <td className="p-4 font-medium text-slate-900">
                  {enrollment.student ? `${enrollment.student.firstName} ${enrollment.student.lastName}` : 'Unknown Student'}
                </td>
                <td className="p-4 text-primary-600 font-medium">
                  {enrollment.course ? enrollment.course.title : 'Unknown Course'}
                </td>
                <td className="p-4 text-slate-600">
                  {new Date(enrollment.enrollmentDate).toLocaleDateString()}
                </td>
              </tr>
            ))}
            {enrollments.length === 0 && (
              <tr>
                <td colSpan="3" className="p-8 text-center text-slate-500">No enrollments found.</td>
              </tr>
            )}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default EnrollmentList;
