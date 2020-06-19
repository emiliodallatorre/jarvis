package input

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

func Input() string {
	fmt.Print("emiliodallatorre: ")

	scanner := bufio.NewScanner(os.Stdin)
	scanner.Scan()

	return strings.Trim(scanner.Text(), " ")
}
