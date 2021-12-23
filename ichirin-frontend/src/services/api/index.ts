import axios, { AxiosError, AxiosInstance } from 'axios';
import { parseCookies } from 'nookies';
import { IchirinAPIError } from './types';

export function createAPIClient(context?: any): AxiosInstance {
  const client = axios.create({
    baseURL: '/backend',
  });

  client.interceptors.request.use((config) => {
    const { token } = parseCookies(context);
    if (token) {
      var header = `Bearer ${token}`;
      config.headers['Authorization'] = header;
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
