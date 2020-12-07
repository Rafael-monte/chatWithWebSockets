import {FileModel} from './fileModel';

export class User {
  id? : number;
  username: string;
  email: string;
  password: string;
  friendCode: string;
  photo: FileModel;
  lastTimeOnline: Date;
}
