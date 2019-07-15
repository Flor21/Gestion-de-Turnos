module.exports = {
    devServer: {
        port: 8081,
        proxy: {
            "/medico":{
                target: "http://localhost:8080",
                secure: false
            }
        }
    }
};