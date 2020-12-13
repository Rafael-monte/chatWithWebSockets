import { User } from './user.models';
export class FriendshipRequest {
    id? : number;
    userWhoSent: User;
    destinatary: User;
    sendDate: Date;
}