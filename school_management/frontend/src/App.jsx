import React from 'react';
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import { AuthProvider, useAuth } from './context/AuthContext';
import AuthLayout from './layouts/AuthLayout';
import DashboardLayout from './layouts/DashboardLayout';
import LoginPage from './pages/LoginPage';
import RegisterPage from './pages/RegisterPage';
import AdminDashboard from './pages/AdminDashboard';
import TeacherDashboard from './pages/TeacherDashboard';
import StudentDashboard from './pages/StudentDashboard';
import StudentList from './pages/StudentList';
import StudentForm from './pages/StudentForm';
import PlaceholderPage from './pages/PlaceholderPage';

const ProtectedRoute = ({ children, allowedRoles }) => {
  const { isAuthenticated, user } = useAuth();
  
  if (!isAuthenticated) {
    return <Navigate to="/login" replace />;
  }

  if (allowedRoles && !allowedRoles.includes(user?.role)) {
    // Redirect to their respective dashboard if they don't have access
    return <Navigate to="/dashboard" replace />;
  }
  
  return children;
};

const DashboardRouter = () => {
  const { user } = useAuth();
  
  if (user?.role === 'ADMIN') return <AdminDashboard />;
  if (user?.role === 'TEACHER') return <TeacherDashboard />;
  if (user?.role === 'STUDENT') return <StudentDashboard />;
  
  return <div className="p-8 text-center text-slate-500">Unrecognized role. Contact Administrator.</div>;
};

function AppRoutes() {
  return (
    <Routes>
      <Route path="/" element={<Navigate to="/dashboard" replace />} />
      
      <Route element={<AuthLayout />}>
        <Route path="/login" element={<LoginPage />} />
        <Route path="/register" element={<RegisterPage />} />
      </Route>

      <Route path="/dashboard" element={<ProtectedRoute><DashboardLayout /></ProtectedRoute>}>
        <Route index element={<DashboardRouter />} />
        
        {/* Student Routes */}
        <Route path="students" element={<ProtectedRoute allowedRoles={['ADMIN', 'TEACHER']}><StudentList /></ProtectedRoute>} />
        <Route path="students/new" element={<ProtectedRoute allowedRoles={['ADMIN']}><StudentForm /></ProtectedRoute>} />
        <Route path="students/:id/edit" element={<ProtectedRoute allowedRoles={['ADMIN']}><StudentForm /></ProtectedRoute>} />
        
        {/* Placeholder Routes */}
        <Route path="teachers" element={<ProtectedRoute allowedRoles={['ADMIN']}><PlaceholderPage title="Teacher Management" /></ProtectedRoute>} />
        <Route path="courses" element={<ProtectedRoute allowedRoles={['ADMIN', 'TEACHER', 'STUDENT']}><PlaceholderPage title="Course Management" /></ProtectedRoute>} />
        <Route path="enrollments" element={<ProtectedRoute allowedRoles={['ADMIN']}><PlaceholderPage title="Enrollment Management" /></ProtectedRoute>} />
        
      </Route>
      
      <Route path="*" element={<Navigate to="/dashboard" replace />} />
    </Routes>
  );
}

function App() {
  return (
    <AuthProvider>
      <BrowserRouter>
        <AppRoutes />
      </BrowserRouter>
    </AuthProvider>
  );
}

export default App;
