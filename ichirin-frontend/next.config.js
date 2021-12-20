const rewriteAPIPath = () => {
  const { API_HOST } = process.env;
  
  return {
    source: '/backend/:path*',
    destination: `${API_HOST}/:path*`,
  };
};

module.exports = {
  rewrites: async () => [rewriteAPIPath()],
  images: {
    domains: ['ichirinnohanayuriscan.com'],
  },
  reactStrictMode: true,
};
