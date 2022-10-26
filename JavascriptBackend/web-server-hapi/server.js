const Hapi = require('@hapi/hapi')
const routes = require('./routes')

const init = async () => {
    const server = Hapi.server({
        port: 3030,
        host: 'localhost',
    })

    server.route(routes)

    await server.start()
    console.log(`Server is run - ${server.info.uri}`)
}

init()