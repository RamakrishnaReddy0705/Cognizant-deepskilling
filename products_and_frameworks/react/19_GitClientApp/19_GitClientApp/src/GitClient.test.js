import axios from 'axios';
import GitClient from './GitClient';

jest.mock('axios');

describe('Git Client Tests', () => {
  test('should return repository names for techiesyed', async () => {
    const mockData = [
      { name: 'react-samples' },
      { name: 'node-utils' },
      { name: 'portfolio-site' },
    ];

    axios.get.mockResolvedValueOnce({ data: mockData });

    const client = new GitClient();
    const repositories = await client.getRepositories('techiesyed');

    expect(repositories).toEqual(['react-samples', 'node-utils', 'portfolio-site']);
  });
});
