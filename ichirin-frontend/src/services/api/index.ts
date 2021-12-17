import axios, { AxiosError, AxiosInstance } from 'axios';
import { parseCookies } from 'nookies';

type IchirinAPIError = {
  authentication: string;
  message: string;
  path?: string;
  timestamp: string;
}

export function createAPIClient(context?: any): AxiosInstance {
  const client = axios.create({
    baseURL: 'http://192.168.99.100:8080',
    // backend ip (docker): troque isso
  });

  client.interceptors.request.use((config) => {
    const { token } = parseCookies(context);
    if (token) {
      var header = `Bearer ${token}`;
      client.defaults.headers['Authorization'] = config.headers['Authorization'] = header;
    }
    return config;
  });
  
  client.interceptors.response.use((value) => value, (error: AxiosError<IchirinAPIError>) => {
    if (error.response) {
      error.message = error.response.data.message;
    }
    return Promise.reject(error);
  });

  return client;
}

export const api: AxiosInstance = createAPIClient();
