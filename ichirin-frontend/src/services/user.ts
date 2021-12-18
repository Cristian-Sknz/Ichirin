import { api } from './api';

export type UserCompact = {
  id: number;
  name: string;
  nickname: string;
  avatarUrl: string;
  createdDate: string;
  lastLogin: string;
}

export enum DataType {
  SHORT = "Short",
  LIMITED = "Limited",
  FULL = "Full",
}

async function getUserData(type: DataType): Promise<UserCompact> {
  var response = await api.get('/api/users/me', {
    params: {
      'type': type
    },
  })

  return response.data;
}

export { getUserData }