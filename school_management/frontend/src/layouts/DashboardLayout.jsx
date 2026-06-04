import React, { useState } from 'react';
import { Outlet, Link, useNavigate, useLocation } from 'react-router-dom';
import { useAuth } from '../context/AuthContext';
import { LayoutDashboard, Users, BookOpen, UserCheck, GraduationCap, LogOut, Menu, X, Shield } from 'lucide-react';

const DashboardLayout = () => {
  const { user, logout } = useAuth();
  const navigate = useNavigate();
  const location = useLocation();
  const [sidebarOpen, setSidebarOpen] = useState(false);

  const handleLogout = () => {
    logout();
    navigate('/login');
  };

  const navItems = [
    { label: 'Dashboard', icon: LayoutDashboard, path: '/dashboard', roles: ['ADMIN', 'TEACHER', 'STUDENT'] },
    { label: 'Students', icon: GraduationCap, path: '/dashboard/students', roles: ['ADMIN', 'TEACHER'] },
    { label: 'Teachers', icon: Users, path: '/dashboard/teachers', roles: ['ADMIN'] },
    { label: 'Courses', icon: BookOpen, path: '/dashboard/courses', roles: ['ADMIN', 'TEACHER', 'STUDENT'] },
    { label: 'Enrollments', icon: UserCheck, path: '/dashboard/enrollments', roles: ['ADMIN'] },
    { label: 'Users', icon: Shield, path: '/dashboard/users', roles: ['ADMIN'] },
  ];

  const allowedNavItems = navItems.filter(item => item.roles.includes(user?.role));

  return (
    <div className="min-h-screen bg-slate-50 flex">
      {/* Sidebar (Mobile Overlay) */}
      <div className={`fixed inset-0 bg-slate-900/50 z-20 lg:hidden ${sidebarOpen ? 'block' : 'hidden'}`} onClick={() => setSidebarOpen(false)} />
      
      {/* Sidebar */}
      <aside className={`fixed lg:static inset-y-0 left-0 w-64 bg-white border-r border-slate-200 z-30 transform transition-transform duration-300 ${sidebarOpen ? 'translate-x-0' : '-translate-x-full lg:translate-x-0'}`}>
        <div className="h-16 flex items-center px-6 border-b border-slate-100">
          <h1 className="text-xl font-bold bg-clip-text text-transparent bg-gradient-to-r from-primary-600 to-purple-600">
            EduManage
          </h1>
          <button className="ml-auto lg:hidden text-slate-500 hover:text-slate-700" onClick={() => setSidebarOpen(false)}>
            <X size={20} />
          </button>
        </div>
        
        <nav className="p-4 space-y-1">
          {allowedNavItems.map((item) => {
            const isActive = location.pathname === item.path || (item.path !== '/dashboard' && location.pathname.startsWith(item.path));
            return (
              <Link 
                key={item.path} 
                to={item.path}
                className={`flex items-center space-x-3 px-4 py-3 transition-colors ${
                  isActive 
                  ? 'bg-primary-50 text-primary-600 font-medium border-l-4 border-primary-600 rounded-r-xl' 
                  : 'text-slate-500 hover:bg-slate-50 hover:text-slate-800 rounded-xl'
                }`}
              >
                <item.icon size={20} className={isActive ? 'text-primary-600' : 'text-slate-400'} />
                <span>{item.label}</span>
              </Link>
            )
          })}
        </nav>
      </aside>

      {/* Main Content */}
      <main className="flex-1 flex flex-col min-w-0 h-screen overflow-hidden">
        {/* Topbar */}
        <header className="h-16 bg-white border-b border-slate-100 flex items-center justify-between px-6 z-10 shrink-0">
          <button className="lg:hidden text-slate-500 hover:text-slate-700" onClick={() => setSidebarOpen(true)}>
            <Menu size={24} />
          </button>
          
          <div className="hidden md:flex items-center bg-slate-50 px-4 py-2 rounded-full w-96 border border-slate-100">
            <input type="text" placeholder="What do you want to find?" className="bg-transparent border-none focus:ring-0 text-sm w-full outline-none text-slate-600 placeholder-slate-400" />
            <svg className="w-4 h-4 text-slate-400" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"></path></svg>
          </div>
          
          <div className="ml-auto flex items-center space-x-4">
            <div className="text-sm text-right hidden sm:block">
              <p className="font-medium text-slate-900">User {user?.role}</p>
              <p className="text-slate-500 capitalize">{user?.role?.toLowerCase()}</p>
            </div>
            <div className="w-10 h-10 rounded-full bg-primary-100 flex items-center justify-center text-primary-700 font-bold">
              {user?.role?.charAt(0) || 'U'}
            </div>
            <button 
              onClick={handleLogout}
              className="p-2 text-slate-400 hover:text-red-500 transition-colors"
              title="Logout"
            >
              <LogOut size={20} />
            </button>
          </div>
        </header>

        {/* Page Content */}
        <div className="flex-1 overflow-auto p-6 bg-[#f3f0fa] animate-fade-in">
          <Outlet />
        </div>
      </main>
    </div>
  );
};

export default DashboardLayout;
