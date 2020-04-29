export class User {
  id: number;
  username: string;
  email: string;
  password: string;
  role: string;
  status: string;

  constructor(id: number, username: string, email: string, password: string, role: string,
              status: string) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.password = password;
    this.role = role;
    this.status = status;
  }
}
