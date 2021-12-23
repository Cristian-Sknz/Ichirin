import { api } from '@ichirin/services/api';
import { DataType } from '../types';
import { UserCompact } from './types';

async function getUserData(type: DataType): Promise<UserCompact> {
  var response = await api.get('/api/users/me', {
    params: {
      'type': type
    },
  })

  return response.data;
}

export { getUserData };