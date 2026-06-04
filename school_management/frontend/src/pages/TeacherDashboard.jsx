import React, { useEffect, useState } from 'react';
import { BookOpen, UserCheck, Calendar } from 'lucide-react';
import api from '../api';
import { useAuth } from '../context/AuthContext';

const TeacherDashboard = () => {
  const { user } = useAuth();
  const [courses, setCourses] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchCourses = async () => {
      if (!user?.id) return;
      try {
        const response = await api.get(`/courses/teacher/user/${user.id}`);
        setCourses(response.data.slice(0, 5));
      } catch (error) {
        console.error("Error fetching courses", error);
      } finally {
        setLoading(false);
      }
    };
    
    fetchCourses();
  }, [user]);

  if (loading) return <div className="h-full flex items-center justify-center"><div className="animate-spin h-8 w-8 border-4 border-primary-500 border-t-transparent rounded-full"></div></div>;

  return (
    <div className="space-y-6">
      <div>
        <h1 className="text-2xl font-bold text-slate-900">Teacher Dashboard</h1>
        <p className="text-slate-500">Welcome back! Here's an overview of your classes.</p>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-3 gap-6">
        <div className="bg-gradient-to-br from-primary-500 to-primary-600 p-6 rounded-2xl text-white shadow-lg">
          <div className="flex items-center justify-between mb-4">
            <h3 className="font-medium text-primary-100">My Courses</h3>
            <BookOpen size={24} className="text-primary-200" />
          </div>
          <p className="text-4xl font-bold">{courses.length}</p>
        </div>
        
        <div className="bg-gradient-to-br from-purple-500 to-purple-600 p-6 rounded-2xl text-white shadow-lg">
          <div className="flex items-center justify-between mb-4">
            <h3 className="font-medium text-purple-100">Total Students</h3>
            <UserCheck size={24} className="text-purple-200" />
          </div>
          <p className="text-4xl font-bold">142</p>
        </div>

        <div className="bg-gradient-to-br from-emerald-500 to-emerald-600 p-6 rounded-2xl text-white shadow-lg">
          <div className="flex items-center justify-between mb-4">
            <h3 className="font-medium text-emerald-100">Upcoming Classes</h3>
            <Calendar size={24} className="text-emerald-200" />
          </div>
          <p className="text-4xl font-bold">3</p>
        </div>
      </div>

      <div className="bg-white rounded-2xl border border-slate-100 shadow-sm overflow-hidden mt-8">
        <div className="p-6 border-b border-slate-100">
          <h3 className="text-lg font-bold text-slate-900">Recent Courses</h3>
        </div>
        <div className="overflow-x-auto">
          <table className="w-full text-left border-collapse">
            <thead>
              <tr className="bg-slate-50 text-slate-500 text-sm">
                <th className="p-4 font-medium">Course Code</th>
                <th className="p-4 font-medium">Course Name</th>
                <th className="p-4 font-medium text-right">Credits</th>
              </tr>
            </thead>
            <tbody>
              {courses.map((course, idx) => (
                <tr key={course.id || idx} className="border-b border-slate-50 hover:bg-slate-50/50 transition-colors">
                  <td className="p-4 font-medium text-slate-900">{course.code}</td>
                  <td className="p-4 text-slate-600">{course.name}</td>
                  <td className="p-4 text-right text-slate-600">{course.credits}</td>
                </tr>
              ))}
              {courses.length === 0 && (
                <tr>
                  <td colSpan="3" className="p-8 text-center text-slate-500">No courses assigned yet.</td>
                </tr>
              )}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
};

export default TeacherDashboard;
