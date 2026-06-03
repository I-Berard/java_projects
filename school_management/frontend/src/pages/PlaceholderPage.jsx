import React from 'react';
import { Hammer } from 'lucide-react';

const PlaceholderPage = ({ title, description }) => {
  return (
    <div className="h-[80vh] flex flex-col items-center justify-center text-center animate-fade-in">
      <div className="w-20 h-20 bg-primary-100 text-primary-600 rounded-2xl flex items-center justify-center mb-6 shadow-sm">
        <Hammer size={40} />
      </div>
      <h2 className="text-3xl font-bold text-slate-900 mb-2">{title}</h2>
      <p className="text-slate-500 max-w-md mx-auto">
        {description || "This module is currently under construction and will be available in the next release."}
      </p>
    </div>
  );
};

export default PlaceholderPage;
