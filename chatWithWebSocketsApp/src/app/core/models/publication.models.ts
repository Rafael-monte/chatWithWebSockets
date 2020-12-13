import { FileModel } from './fileModel.models';
import { User } from './user.models';

export class Publication {
    id? : number;
    text: string;
    publishingDate: Date;
    tags: string;
    upvotes? : number;
    file: FileModel;
    user: User;
}