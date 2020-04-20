import {User} from './user';

export class Post {
  username: string;
  postId: number;
  id: number;
  description: string;
  user?: User;
  file?: File;
  login?: string;
  userId?: number;
  likesCount?: number;
  like: boolean;
}
