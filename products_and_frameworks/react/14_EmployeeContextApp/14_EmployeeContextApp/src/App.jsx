import { useState } from 'react';
import ThemeContext from './ThemeContext';
import EmployeeList from './EmployeeList';

const employees = [
  { id: 1, name: 'Ananya Rao', role: 'Frontend Engineer' },
  { id: 2, name: 'Vikram Shah', role: 'Backend Engineer' },
  { id: 3, name: 'Priya Menon', role: 'QA Analyst' },
];

function App() {
  const [theme, setTheme] = useState('light');

  return (
    <ThemeContext.Provider value={theme}>
      <div>
        <h1>Employee Management</h1>
        <button onClick={() => setTheme(theme === 'light' ? 'dark' : 'light')}>
          Toggle Theme
        </button>
        <EmployeeList employees={employees} />
      </div>
    </ThemeContext.Provider>
  );
}

export default App;
