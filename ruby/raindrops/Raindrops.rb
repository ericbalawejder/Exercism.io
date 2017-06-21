# Convert a number to a string, the contents of which depend on the number's factors.
class Raindrops
  def self.convert(integer)
    raindrops = ''
    raindrops << 'Pling' if (integer % 3).zero?
    raindrops << 'Plang' if (integer % 5).zero?
    raindrops << 'Plong' if (integer % 7).zero?
    raindrops << integer.to_s if raindrops == ''
    raindrops
  end
end

module BookKeeping
  # Where the version number matches the one in the test.
  VERSION = 3
end
