#GIGASECOND = 10**9
GIGASECOND = 1_000_000_000

class Gigasecond
  # argument input format: (Time.utc(2015, 1, 24, 22, 0, 0))
  def self.from(birth_date)
    birth_date + GIGASECOND
  end
end

module BookKeeping
  # Where the version number matches the one in the test.
  VERSION = 6 
end