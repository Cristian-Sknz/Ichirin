export function removeAccents(text : string) : string {
    return text.normalize('NFD').replace(/[\u0300-\u036f]/g, "");
}

export function textLimiter(text: string, size: number) {
    if (text.length > size){
      return `${text.substring(0, size)}...`;
    }
    return text;
  }