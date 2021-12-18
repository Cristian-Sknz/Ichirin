import { NextMiddleware, NextRequest, NextResponse } from 'next/server';

export const middleware: NextMiddleware = (req, a) => {
  switch (req.url) {
    case '/signin': {
      return checkToken(req);
    }
    case '/signup': {
      return checkToken(req);
    }
    case '/logout': {
      return checkToken(req, true);
    }
    default:
      return null;
  }
};

function checkToken(req: NextRequest, clear?: boolean) {
  const { token } = req.cookies;
  if (token) {
    return !clear
      ? NextResponse.redirect('/')
      : NextResponse.redirect('/').clearCookie('token');
  }
  return null;
}
