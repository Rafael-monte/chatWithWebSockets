import {FileModel} from './fileModel.models';

export class User {
  id? : number;
  username: String;
  email: string;
  password: string;
  friendCode: string;
  lastTimeOnline: Date;
  photo: FileModel;
}
