// Common file for smaller / more adhoc interfaces and data models. Re-used but not meriting enough importance to have their own files

export interface OptionPair { // small interface used for custom option dropdown component
  displayLabel: string; // text that will read onscreen
  option: string; // actual option to emit to parent component for processing
}
