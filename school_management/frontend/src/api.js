import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:9000/api', // Adjust this if the backend port is different
});

// Add a request interceptor to attach the JWT token
api.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem('token');
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
  },
  (error) => Promise.reject(error)
);

export default api;
