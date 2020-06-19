package telegram

import (
	"../terminal"
	"fmt"
	"github.com/go-telegram-bot-api/telegram-bot-api"
	"log"
)

type TelegramChannel struct {
	telegramBot *tgbotapi.BotAPI
}

func (t TelegramChannel) Input() string {
	t.telegramBot.Debug = true

	log.Printf("Authorized on account %s", t.telegramBot.Self.UserName)

	u := tgbotapi.NewUpdate(0)
	u.Timeout = 60

	updates, error := t.telegramBot.GetUpdatesChan(u)

	fmt.Println(error)

	for update := range updates {
		if update.Message == nil { // ignore any non-Message Updates
			continue
		}

		log.Printf("[%s] %s", update.Message.From.UserName, update.Message.Text)

		msg := tgbotapi.NewMessage(update.Message.Chat.ID, update.Message.Text)
		msg.ReplyToMessageID = update.Message.MessageID

		t.telegramBot.Send(msg)
	}

	return "AAA"
}

const telegramToken string = "1167083350:AAGK2IuNKNeFVCJAT-ZyCj_36s9l5e8QujY"

func (t TelegramChannel) Initialize() {
	telegramBot, apiError := tgbotapi.NewBotAPI(telegramToken)

	if apiError != nil {
		terminal.Output("", apiError)
	} else {
		t.telegramBot = telegramBot
	}
}
