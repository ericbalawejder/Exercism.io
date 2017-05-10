# https://github.com/rubyworks/strmask
# Mask provides a string utility to manipulate strings 
# in logicomathematical manner, ie. add, subtract, xor, etc.
require 'strmask'

class Hamming
  def self.compute(strand1, strand2)
    
    # Argument error for unequal strand lengths
    raise ArgumentError, 'Unequal strand lengths.' if strand1.length != strand2.length
    
    # Create String Mask object from argument DNA strings. 
    dna1 = String::Mask.new(strand1, '.')
    dna2 = String::Mask.new(strand2, '.')
    
    # For Subtraction, where the characters are the same, the result is empty, where they 
    # differ the result reflects the last string.
    result = dna1 - dna2
    
    # Regex for counting characters, one or more uppercase letters. Result Mask object
    # has white space charcaters denoted by '.' 
    regexp = Regexp.new(/[A-Z]+/)
    
    # Result Mask object to string, split each character, join array indexes to string and 
    # scan for all regex matches. This takes "CCC" and yields "C" "C" "C"
    character_count = result.to_s.split("").join(" ").scan(regexp)
    
    # Hamming distance of two DNA strands
    hamming_distance = character_count.length
    return hamming_distance
  end
end

module BookKeeping
  # Where the version number matches the one in the test.
  VERSION = 3
end


puts Hamming.compute("GAGCCTACTAACGGGAT", "CATCGTAATGACGGCCT")
puts Hamming.compute("", "")
