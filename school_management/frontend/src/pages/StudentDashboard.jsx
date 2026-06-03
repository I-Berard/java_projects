import React, { useEffect, useState } from 'react';
import { BookOpen, Calendar, Award } from 'lucide-react';
import api from '../api';

const StudentDashboard = () => {
  const [courses, setCourses] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    // Mock fetching student's enrolled courses
    const fetchCourses = async () => {
      try {
        const response = await api.get('/courses');
        setCourses(response.data.slice(0, 4));
      } catch (error) {
        console.error("Error fetching courses", error);
      } finally {
        setLoading(false);
      }
    };
    
    fetchCourses();
  }, []);

  if (loading) return <div className="h-full flex items-center justify-center"><div className="animate-spin h-8 w-8 border-4 border-primary-500 border-t-transparent rounded-full"></div></div>;

  return (
    <div className="space-y-6">
      <div>
        <h1 className="text-2xl font-bold text-slate-900">Student Dashboard</h1>
        <p className="text-slate-500">Welcome! Here's your current academic overview.</p>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-3 gap-6">
        <div className="bg-white p-6 rounded-2xl border border-slate-100 shadow-sm flex items-center space-x-4">
          <div className="w-12 h-12 rounded-xl bg-blue-50 text-blue-600 flex items-center justify-center">
            <BookOpen size={24} />
          </div>
          <div>
            <p className="text-sm font-medium text-slate-500">Enrolled Courses</p>
            <p className="text-2xl font-bold text-slate-900">{courses.length}</p>
          </div>
        </div>

        <div className="bg-white p-6 rounded-2xl border border-slate-100 shadow-sm flex items-center space-x-4">
          <div className="w-12 h-12 rounded-xl bg-purple-50 text-purple-600 flex items-center justify-center">
            <Award size={24} />
          </div>
          <div>
            <p className="text-sm font-medium text-slate-500">Current GPA</p>
            <p className="text-2xl font-bold text-slate-900">3.8</p>
          </div>
        </div>
        
        <div className="bg-white p-6 rounded-2xl border border-slate-100 shadow-sm flex items-center space-x-4">
          <div className="w-12 h-12 rounded-xl bg-orange-50 text-orange-600 flex items-center justify-center">
            <Calendar size={24} />
          </div>
          <div>
            <p className="text-sm font-medium text-slate-500">Upcoming Exams</p>
            <p className="text-2xl font-bold text-slate-900">2</p>
          </div>
        </div>
      </div>

      <h3 className="text-lg font-bold text-slate-900 mt-8 mb-4">My Courses</h3>
      <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
        {courses.map((course, idx) => (
          <div key={course.id || idx} className="bg-white p-6 rounded-2xl border border-slate-100 shadow-sm hover:shadow-md transition-shadow cursor-pointer">
            <div className="flex justify-between items-start mb-4">
              <div className="bg-primary-50 text-primary-700 px-3 py-1 rounded-full text-xs font-medium">
                {course.code}
              </div>
              <div className="text-sm font-medium text-slate-500">{course.credits} Credits</div>
            </div>
            <h4 className="text-lg font-bold text-slate-900 mb-2">{course.name}</h4>
            <div className="w-full bg-slate-100 rounded-full h-2 mb-2 mt-4">
              <div className="bg-primary-500 h-2 rounded-full" style={{ width: `${Math.floor(Math.random() * 60) + 20}%` }}></div>
            </div>
            <p className="text-xs text-slate-500 text-right">Progress</p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default StudentDashboard;
