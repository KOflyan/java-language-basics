export enum Role {
    ADMIN = 'ADMIN',
    USER = 'USER'
}

export type Trainer = {
    id: number
    name: string
    location: string
    role: Role
    createdAt: string
}
