import React, { useEffect, useState } from 'react';
import { Users, BookOpen, UserCheck, TrendingUp } from 'lucide-react';
import api from '../api';
import { BarChart, Bar, XAxis, YAxis, CartesianGrid, Tooltip, ResponsiveContainer, LineChart, Line } from 'recharts';

const StatCard = ({ title, value, icon: Icon, trend }) => (
  <div className="bg-white p-6 rounded-2xl border border-slate-100 shadow-sm hover:shadow-md transition-shadow">
    <div className="flex items-start justify-between">
      <div>
        <p className="text-sm font-medium text-slate-500 mb-1">{title}</p>
        <h3 className="text-3xl font-bold text-slate-900">{value}</h3>
      </div>
      <div className="w-12 h-12 rounded-xl bg-primary-50 flex items-center justify-center text-primary-600">
        <Icon size={24} />
      </div>
    </div>
    <div className="mt-4 flex items-center text-sm">
      <TrendingUp size={16} className="text-emerald-500 mr-1" />
      <span className="text-emerald-500 font-medium">{trend}%</span>
      <span className="text-slate-400 ml-2">vs last month</span>
    </div>
  </div>
);

const AdminDashboard = () => {
  const [stats, setStats] = useState({ students: 0, teachers: 0, courses: 0, enrollments: 0 });
  const [loading, setLoading] = useState(true);

  // Mock data for charts
  const enrollmentData = [
    { name: 'Jan', students: 40 }, { name: 'Feb', students: 30 },
    { name: 'Mar', students: 55 }, { name: 'Apr', students: 45 },
    { name: 'May', students: 70 }, { name: 'Jun', students: 65 },
  ];

  useEffect(() => {
    const fetchStats = async () => {
      try {
        const [students, courses] = await Promise.all([
          api.get('/students'),
          api.get('/courses'),
        ]);
        
        // In a real scenario we might have an endpoint for counts.
        // Assuming the endpoints return lists here:
        setStats({
          students: students.data.length || 0,
          teachers: Math.floor(Math.random() * 15) + 5, // Mock if no direct endpoint
          courses: courses.data.length || 0,
          enrollments: Math.floor(Math.random() * 100) + 20, // Mock
        });
      } catch (error) {
        console.error("Error fetching dashboard stats", error);
      } finally {
        setLoading(false);
      }
    };
    
    fetchStats();
  }, []);

  if (loading) return <div className="h-full flex items-center justify-center"><div className="animate-spin h-8 w-8 border-4 border-primary-500 border-t-transparent rounded-full"></div></div>;

  return (
    <div className="space-y-6">
      <div>
        <h1 className="text-2xl font-bold text-slate-900">Admin Overview</h1>
        <p className="text-slate-500">Welcome to your school administration dashboard.</p>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-6">
        <StatCard title="Total Students" value={stats.students} icon={Users} trend="12" />
        <StatCard title="Total Teachers" value={stats.teachers} icon={Users} trend="4" />
        <StatCard title="Active Courses" value={stats.courses} icon={BookOpen} trend="8" />
        <StatCard title="Total Enrollments" value={stats.enrollments} icon={UserCheck} trend="24" />
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-2 gap-6 mt-8">
        <div className="bg-white p-6 rounded-2xl border border-slate-100 shadow-sm">
          <h3 className="text-lg font-bold text-slate-900 mb-6">Enrollment Trends</h3>
          <div className="h-72">
            <ResponsiveContainer width="100%" height="100%">
              <AreaChart data={enrollmentData} margin={{ top: 10, right: 10, left: -20, bottom: 0 }}>
                <defs>
                  <linearGradient id="colorStudents" x1="0" y1="0" x2="0" y2="1">
                    <stop offset="5%" stopColor="#3b82f6" stopOpacity={0.8}/>
                    <stop offset="95%" stopColor="#3b82f6" stopOpacity={0}/>
                  </linearGradient>
                </defs>
                <CartesianGrid strokeDasharray="3 3" vertical={false} stroke="#f1f5f9" />
                <XAxis dataKey="name" axisLine={false} tickLine={false} tick={{fill: '#64748b'}} />
                <YAxis axisLine={false} tickLine={false} tick={{fill: '#64748b'}} />
                <Tooltip 
                  contentStyle={{ borderRadius: '12px', border: 'none', boxShadow: '0 4px 6px -1px rgb(0 0 0 / 0.1)' }}
                />
                <Area type="monotone" dataKey="students" stroke="#3b82f6" strokeWidth={3} fillOpacity={1} fill="url(#colorStudents)" />
              </AreaChart>
            </ResponsiveContainer>
          </div>
        </div>

        <div className="bg-white p-6 rounded-2xl border border-slate-100 shadow-sm">
          <h3 className="text-lg font-bold text-slate-900 mb-6">Course Distribution</h3>
          <div className="h-72">
            <ResponsiveContainer width="100%" height="100%">
              <BarChart data={enrollmentData.slice(0, 4)} margin={{ top: 10, right: 10, left: -20, bottom: 0 }}>
                <CartesianGrid strokeDasharray="3 3" vertical={false} stroke="#f1f5f9" />
                <XAxis dataKey="name" axisLine={false} tickLine={false} tick={{fill: '#64748b'}} />
                <YAxis axisLine={false} tickLine={false} tick={{fill: '#64748b'}} />
                <Tooltip cursor={{fill: '#f8fafc'}} contentStyle={{ borderRadius: '12px', border: 'none', boxShadow: '0 4px 6px -1px rgb(0 0 0 / 0.1)' }}/>
                <Bar dataKey="students" fill="#8b5cf6" radius={[6, 6, 0, 0]} />
              </BarChart>
            </ResponsiveContainer>
          </div>
        </div>
      </div>
    </div>
  );
};

// Also import AreaChart, Area for the component above
import { AreaChart, Area } from 'recharts';

export default AdminDashboard;
