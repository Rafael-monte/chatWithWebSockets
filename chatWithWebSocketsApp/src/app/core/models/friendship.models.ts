import { User } from './user.models';
export class Friendship {
    id? : number;
    user: User;
    friend: User;
}
