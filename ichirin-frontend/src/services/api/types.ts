export enum DataType {
  SHORT = "Short",
  LIMITED = "Limited",
  FULL = "Full",
}

export type IchirinAPIError = {
  authentication: string;
  message: string;
  path?: string;
  timestamp: string;
}