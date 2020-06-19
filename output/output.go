package output

import (
	"../channels/terminal"
)

func Output(output string, error error) {
	terminal.Output(output, error)
}
