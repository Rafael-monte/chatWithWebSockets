import { Publication } from './publication.models';
import { FileModel } from './fileModel.models';
import { User } from './user.models';
export class Commentary {
    id? : number;
    publication: Publication;
    text : string;
    file: FileModel;
    user: User;
    upvotes? : number;
}