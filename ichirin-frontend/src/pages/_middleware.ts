import { NextMiddleware, NextRequest, NextResponse } from 'next/server';

export const middleware: NextMiddleware = (req) => {
  switch (req.url) {
    case '/signin': {
      return checkToken(req);
    }
    case '/signup': {
      return checkToken(req);
    }
    default:
      return null;
  }
}

function checkToken(req: NextRequest) {
  const { token } = req.cookies;
  if (token) {
    return NextResponse.redirect('/');
  }
  return null;
}