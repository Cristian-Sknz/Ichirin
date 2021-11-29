import 'styled-components';

declare module 'styled-components' {
  export interface DefaultTheme {
    title: string;

    colors: {
      background: string;
      primary: string;
      secondary: string;
      gray: string;
      pink: string;

      text: string;
    };

    fonts: {
      primary: string;
      secondary: string;
    };

    sizes: {
      text: {
        default: string;
        small: string;
        medium: string;
      };
    };
  }
}
