package processing

import (
	"fmt"
	"github.com/aichaos/rivescript-go"
)

type Processor struct {
	bot *rivescript.RiveScript
}

func (p *Processor) Process(input string) (string, error) {
	response, responseError := p.bot.Reply("user", input)

	return response, responseError
}

func (p *Processor) Initialize() {
	p.bot = rivescript.New(&rivescript.Config{
		UTF8:  true,  // enable UTF-8 mode
		Debug: false, // enable debug mode
	})

	loadingError := p.bot.LoadDirectory("./replies")
	if loadingError != nil {
		fmt.Println(loadingError)
	}

	sortingError := p.bot.SortReplies()
	if sortingError != nil {
		fmt.Println(sortingError)
	}

	fmt.Println("Bot inizializzato correttamente.")
}
