package input

import (
	"../channels/telegram"
	"../channels/terminal"
	"fmt"
)

type Input struct {
	InputType string
}

func (i Input) Input() string {

	switch i.InputType {
	case Terminal:

		return terminal.Input()
	case Telegram:
		var telegramChannel telegram.TelegramChannel
		telegramChannel.Initialize()
		telegramChannel.Input()
	}
}

func (i Input) Initialize(inputType string) {
	i.InputType = inputType

	fmt.Println("Inizializzato l'input col canale: [" + inputType + "].")
}

const (
	Terminal = "terminal"
	Telegram = "telegram"
)
