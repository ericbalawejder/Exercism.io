# class Hamming
class Hamming
  def self.compute(strand1, strand2)
    raise ArgumentError, 'Strand lengths are unequal.' unless strand1.length == strand2.length
    
    # string to char array for zip
    strand1 = strand1.chars
    strand2 = strand2.chars
    strand1.zip(strand2).count { |nucleotide1, nucleotide2| nucleotide1 != nucleotide2 }
  end
end

module BookKeeping
  # Where the version number matches the one in the test.
  VERSION = 3
end