# Class Pangram
class Pangram
  def self.pangram?(phrase)
      ([*'a'..'z'] - phrase.downcase.chars).empty?
  end
end

module BookKeeping
  # Where the version number matches the one in the test.
  VERSION = 4
end
