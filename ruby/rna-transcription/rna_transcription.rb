# Given a DNA strand, return its RNA complement (per RNA transcription).
class Complement
  COMPLEMENTS = { 'G' => 'C',
                  'C' => 'G',
                  'T' => 'A',
                  'A' => 'U' }.freeze
  # will not work
  # COMPLEMENTS.default = "*"

  def self.of_dna(strand)
    # COMPLEMENTS.fetch(nucleotide, "default_value for nil key")
    rna = strand.chars.map { |nucleotide| COMPLEMENTS.fetch(nucleotide, '*') }.join
    # if rna contains the default value, make rna the empty string
    rna = '' if rna.include?('*')
    rna
  end
end

module BookKeeping
  # Where the version number matches the one in the test.
  VERSION = 4
end
