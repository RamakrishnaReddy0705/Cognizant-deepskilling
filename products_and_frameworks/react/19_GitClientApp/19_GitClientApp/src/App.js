import { useEffect, useState } from 'react';
import GitClient from './GitClient';

const gitClient = new GitClient();

function App() {
  const [repositories, setRepositories] = useState([]);
  const [username] = useState('techiesyed');

  useEffect(() => {
    gitClient.getRepositories(username).then((names) => {
      setRepositories(names);
    });
  }, [username]);

  return (
    <div>
      <h1>Repositories for {username}</h1>
      <ul>
        {repositories.map((name) => (
          <li key={name}>{name}</li>
        ))}
      </ul>
    </div>
  );
}

export default App;
