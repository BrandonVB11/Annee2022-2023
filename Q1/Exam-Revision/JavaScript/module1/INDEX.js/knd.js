//creer un bot pour discord
const Discord = require('discord.js');
const client = new Discord.Client();
const prefix = '!';
const fs = require('fs');
const { Collection } = require('discord.js');
const { token } = require('./config.json');
const { readdirSync } = require('fs');
const { join } = require('path');
const { Player } = require('discord-player');
const player = new Player(client);
client.player = player;
client.commands = new Collection();
client.aliases = new Collection();
client.categories = readdirSync(join(__dirname, "commands"));
["command"].forEach(handler => {
    require(join(__dirname, `handlers/${handler}`))(client);
}
);
client.on('ready', () => {
    console.log('Ready!');
    client.user.setActivity('!help', { type: 'LISTENING' });
}
);

client.on('message', async message => {
    const args = message.content.slice(prefix.length).trim().split(/ +/g);
    const cmd = args.shift().toLowerCase();
    if (message.author.bot) return;
    if (!message.content.startsWith(prefix)) return;
    if (!client.commands.has(cmd)) return;
    try {
        client.commands.get(cmd).run(client, message, args);
    } catch (error) {
        console.error(error);
    }
}
);

client.login(token);