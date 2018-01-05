require 'set'

# Class Pangram
class Pangram
  def self.pangram?(phrase)
    character_set = Set[]
    phrase.downcase.each_byte { |x| character_set.add(x) if x >= 97 && x <= 122 }
    character_set.size == 26
  end
end

module BookKeeping
  # Where the version number matches the one in the test.
  VERSION = 4
end
