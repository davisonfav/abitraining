db.createUser(
    {
        user: "davison",
        pwd: "123456",
        roles: [
            {
                role: "readWrite",
                db: "training"
            }
        ]
    }
)