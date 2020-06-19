package terminal

import (
	"bufio"
	"fmt"
	"github.com/gookit/color"
	"os"
	"strings"
)

func Input() string {
	fmt.Print("emiliodallatorre: ")

	scanner := bufio.NewScanner(os.Stdin)
	scanner.Scan()

	return strings.Trim(scanner.Text(), " ")
}

func Output(output string, error error) {
	if output != "" {
		fmt.Println("Jarvis: " + output)
		fmt.Println()

		return
	}

	color.Error.Println(error)
}
