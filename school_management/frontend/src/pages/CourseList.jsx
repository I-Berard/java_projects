import React, { useState, useEffect } from 'react';
import api from '../api';
import { BookOpen, AlertCircle, Plus } from 'lucide-react';
import { useAuth } from '../context/AuthContext';

const CourseList = () => {
  const { user } = useAuth();
  const [courses, setCourses] = useState([]);
  const [teachers, setTeachers] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');
  const [showAddModal, setShowAddModal] = useState(false);
  const [newCourse, setNewCourse] = useState({ code: '', title: '', description: '', teacherId: '' });

  useEffect(() => {
    fetchCourses();
    fetchTeachers();
  }, []);

  const fetchCourses = async () => {
    try {
      const response = await api.get('/courses');
      setCourses(response.data);
    } catch (err) {
      setError('Failed to fetch courses.');
      console.error(err);
    } finally {
      setLoading(false);
    }
  };

  const fetchTeachers = async () => {
    try {
      const response = await api.get('/teachers');
      setTeachers(response.data);
    } catch (err) {
      console.error('Failed to fetch teachers', err);
    }
  };

  const handleAddCourse = async (e) => {
    e.preventDefault();
    try {
      const response = await api.post('/courses', newCourse);
      setCourses([...courses, response.data]);
      setShowAddModal(false);
      setNewCourse({ code: '', title: '', description: '', teacherId: '' });
    } catch (err) {
      alert('Failed to add course.');
      console.error(err);
    }
  };

  if (loading) return <div className="p-8 flex justify-center"><div className="animate-spin h-8 w-8 border-4 border-primary-500 border-t-transparent rounded-full"></div></div>;

  return (
    <div className="space-y-6">
      <div className="flex justify-between items-center">
        <div>
          <h1 className="text-2xl font-bold text-slate-900">Course Management</h1>
          <p className="text-slate-500">View and manage courses</p>
        </div>
        {(user?.role === 'ADMIN' || user?.role === 'TEACHER') && (
          <button 
            onClick={() => setShowAddModal(true)}
            className="bg-primary-600 hover:bg-primary-700 text-white px-4 py-2 rounded-xl flex items-center transition-colors"
          >
            <Plus size={20} className="mr-2" /> Add Course
          </button>
        )}
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
            <h3 className="text-lg font-bold mb-4 text-slate-900">Add New Course</h3>
            <form onSubmit={handleAddCourse} className="space-y-4">
              <div>
                <label className="block text-sm font-medium text-slate-700 mb-1">Course Code</label>
                <input required type="text" value={newCourse.code} onChange={(e) => setNewCourse({...newCourse, code: e.target.value})} className="w-full px-3 py-2 border border-slate-200 rounded-xl focus:outline-none focus:ring-2 focus:ring-primary-500" />
              </div>
              <div>
                <label className="block text-sm font-medium text-slate-700 mb-1">Course Title</label>
                <input required type="text" value={newCourse.title} onChange={(e) => setNewCourse({...newCourse, title: e.target.value})} className="w-full px-3 py-2 border border-slate-200 rounded-xl focus:outline-none focus:ring-2 focus:ring-primary-500" />
              </div>
              <div>
                <label className="block text-sm font-medium text-slate-700 mb-1">Description</label>
                <input required type="text" value={newCourse.description} onChange={(e) => setNewCourse({...newCourse, description: e.target.value})} className="w-full px-3 py-2 border border-slate-200 rounded-xl focus:outline-none focus:ring-2 focus:ring-primary-500" />
              </div>
              <div>
                <label className="block text-sm font-medium text-slate-700 mb-1">Teacher</label>
                <select required value={newCourse.teacherId} onChange={(e) => setNewCourse({...newCourse, teacherId: e.target.value})} className="w-full px-3 py-2 border border-slate-200 rounded-xl focus:outline-none focus:ring-2 focus:ring-primary-500">
                  <option value="">Select Teacher...</option>
                  {teachers.map(t => (
                    <option key={t.id} value={t.id}>{t.fullName}</option>
                  ))}
                </select>
              </div>
              <div className="flex justify-end space-x-3 mt-6">
                <button type="button" onClick={() => setShowAddModal(false)} className="px-4 py-2 text-slate-600 hover:bg-slate-50 rounded-xl">Cancel</button>
                <button type="submit" className="px-4 py-2 bg-primary-600 hover:bg-primary-700 text-white rounded-xl">Save Course</button>
              </div>
            </form>
          </div>
        </div>
      )}

      <div className="bg-white rounded-2xl shadow-sm border border-slate-100 overflow-hidden">
        <table className="w-full text-left border-collapse">
          <thead>
            <tr className="bg-slate-50 text-slate-600 text-sm border-b border-slate-100">
              <th className="p-4 font-medium">Course Code</th>
              <th className="p-4 font-medium">Title</th>
              <th className="p-4 font-medium">Description</th>
              <th className="p-4 font-medium">Teacher</th>
            </tr>
          </thead>
          <tbody className="divide-y divide-slate-100">
            {courses.map(course => (
              <tr key={course.id} className="hover:bg-slate-50/50 transition-colors">
                <td className="p-4 font-medium text-primary-600">{course.code}</td>
                <td className="p-4 text-slate-900">{course.title}</td>
                <td className="p-4 text-slate-600">{course.description}</td>
                <td className="p-4 text-slate-600">
                  {course.teacher ? course.teacher.fullName : 'Unassigned'}
                </td>
              </tr>
            ))}
            {courses.length === 0 && (
              <tr>
                <td colSpan="4" className="p-8 text-center text-slate-500">No courses found.</td>
              </tr>
            )}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default CourseList;
